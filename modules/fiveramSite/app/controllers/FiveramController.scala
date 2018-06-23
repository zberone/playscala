package controllers.fiveramSite

import javax.inject.{Inject, Singleton}
import play.api._
import play.api.i18n.{I18nSupport, Lang, MessagesApi}
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 * 这是fiveram的controller
 *
 */
@Singleton
class FiveramController @Inject() (val messagesApi: MessagesApi, conf: Configuration) extends Controller with I18nSupport {

  // val Fiveram = Redirect(routes.FiveramController.index())
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.fiveramPC.index("AnormHome"))
  }
  def about = Action {
    Ok(views.html.fiveramPC.about("About"))
  }
  def contact = Action {
    Ok(views.html.fiveramPC.contact("Contact"))
  }
  def brand = Action {
    Ok(views.html.fiveramPC.brand("Brand"))
  }
  def careers = Action {
    Ok(views.html.fiveramPC.careers("Careers"))
  }
  def redumbrella = Action {
    Ok(views.html.fiveramPC.redumbrella("RedUmbrella"))
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
