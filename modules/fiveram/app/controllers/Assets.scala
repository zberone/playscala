package controllers.fiveram

import play.api.Configuration
import javax.inject.Inject

class Assets @Inject() (errorHandler: fiveram.ErrorHandler) extends controllers.common.Assets(errorHandler)
class SharedResources @Inject() (errorHandler: fiveram.ErrorHandler, conf: Configuration) extends controllers.common.SharedResources(errorHandler, conf)