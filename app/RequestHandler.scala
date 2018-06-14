import javax.inject.Inject
import play.api.http._
import play.api.mvc.{ RequestHeader, EssentialAction, Action, Results }
import play.api.routing.Router

class VirtualHostRequestHandler @Inject() (
  errorHandler: HttpErrorHandler,
  configuration: HttpConfiguration,
  filters: HttpFilters,
  webRouter: web.Routes,
  adminRouter: admin.Routes,
  princegroupRouter: princegroup.Routes,
  fiveramRouter: fiveram.Routes
) extends DefaultHttpRequestHandler(
  webRouter, errorHandler, configuration, filters
) {

  /*
	* Gets the subdomain: "admin" o "www"
	*/
  //private def getSubdomain(request: RequestHeader) = request.domain.replaceFirst("[\\.]?[^\\.]+[\\.][^\\.]+$", "")
  private def getSubdomain(request: RequestHeader) = request.host.split(":")(0)

  /*
  * Delegates to each router depending on the corresponding subdomain
  */
  override def routeRequest(request: RequestHeader) = getSubdomain(request) match {
    case "web.example.com" => webRouter.routes.lift(rewriteAssets("web", request))
    case "princegroup.example.com" => princegroupRouter.routes.lift(rewriteAssets("princegroup", request))
    case "fiveram.example.com" => fiveramRouter.routes.lift(rewriteAssets("fiveram", request))
    case _ => adminRouter.routes.lift(rewriteAssets("admin", request))
  }

  /*
	* Rewrite the Assets routes for the root project, accessing to the corresponding lib.
	*/
  private def rewriteAssets(subproject: String, request: RequestHeader): RequestHeader = {
    val pub = s"""/public/(.*)""".r
    val css = s"""/css/(.*)""".r
    val js = s"""/js/(.*)""".r
    val img = s"""/img/(.*)""".r
    request.path match {
      case pub(file) => request.copy(path = s"/lib/$subproject/$file")
      case css(file) => request.copy(path = s"/lib/$subproject/stylesheets/$file")
      case js(file) => request.copy(path = s"/lib/$subproject/javascripts/$file")
      case img(file) => request.copy(path = s"/lib/$subproject/images/$file")
      case _ => request
    }
  }
}