package controllers.fiveram


import javax.inject._
import play.api._
import play.api.i18n.{I18nSupport, Lang}
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 * 这是fiveram的controller
 *
 */
@Singleton
class FiveramController @Inject() (cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

 // val Fiveram = Redirect(routes.FiveramController.index())
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.fiveram.html.index("AnormHome"))
  }
  def about = Action {
    Ok(views.fiveram.html.about("About"))
  }
  def contact = Action {
    Ok(views.fiveram.html.contact("Contact"))
  }
  def brand = Action {
    Ok(views.fiveram.html.brand("Brand"))
  }
  def careers = Action {
    Ok(views.fiveram.html.careers("Careers"))
  }
  def redumbrella = Action {
    Ok(views.fiveram.html.redumbrella("RedUmbrella"))
  }

  def selectLang(lang: String) = Action { implicit request =>
    Logger.logger.debug("Change user lang to : " + lang)
    request.headers.get(REFERER).map { referer =>
      Redirect(referer).withLang(Lang(lang))
    }.getOrElse {
      Redirect(routes.FiveramController.index).withLang(Lang(lang))
    }
  }

}
