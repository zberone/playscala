package controllers.princegroup

import models.princegroup._
import play.api._
import play.api.mvc._
import play.api.i18n.{ I18nSupport, MessagesApi, Messages, Lang }
import net.ceedubs.ficus.Ficus._
import javax.inject.{ Inject, Singleton }

@Singleton
class Application @Inject() (val messagesApi: MessagesApi, conf: Configuration) extends Controller with I18nSupport {

  def index = Action { implicit request =>
    val computers = PrincegroupWeb.list
    Ok(views.html.princegroup.index(Messages("princegroup.subtitle"), computers, configThisFile = conf.underlying.as[String]("this.file")))
  }

  def about = Action { implicit request =>
    val computers = PrincegroupWeb.list
    Ok(views.html.princegroup.about(Messages("princegroup.subtitle"), computers, configThisFile = conf.underlying.as[String]("this.file")))
  }

  def brands(ID: String) = Action { implicit request =>
    val computers = PrincegroupWeb.list
    //    if (List("fiveram", "bibi", "pid").contains(ID)) {
    //      Ok(views.html.princegroup.brands(Messages("princegroup.subtitle"), ID, computers, configThisFile = conf.underlying.as[String]("this.file")))
    //    }
    Ok(views.html.princegroup.brands(Messages("princegroup.subtitle"), ID, computers, configThisFile = conf.underlying.as[String]("this.file")))
  }

  def contact = Action { implicit request =>
    val computers = PrincegroupWeb.list
    Ok(views.html.princegroup.contact(Messages("princegroup.subtitle"), computers, configThisFile = conf.underlying.as[String]("this.file")))
  }

  def csr = Action { implicit request =>
    val computers = PrincegroupWeb.list
    Ok(views.html.princegroup.csr(Messages("princegroup.subtitle"), computers, configThisFile = conf.underlying.as[String]("this.file")))
  }

  def selectLang(lang: String) = Action { implicit request =>
    Logger.logger.debug("Change user lang to : " + lang)
    request.headers.get(REFERER).map { referer =>
      Redirect(referer).withLang(Lang(lang))
    }.getOrElse {
      Redirect(routes.Application.index).withLang(Lang(lang))
    }
  }

}