package controllers.fiveramSite

import play.api.Configuration
import javax.inject.Inject

class Assets @Inject() (errorHandler: fiveramSite.ErrorHandler) extends controllers.common.Assets(errorHandler)
class SharedResources @Inject() (errorHandler: fiveramSite.ErrorHandler, conf: Configuration) extends controllers.common.SharedResources(errorHandler, conf)