package controllers.princegroup

import play.api.Configuration
import javax.inject.Inject

class Assets @Inject() (errorHandler: princegroup.ErrorHandler) extends controllers.common.Assets(errorHandler)
class SharedResources @Inject() (errorHandler: princegroup.ErrorHandler, conf: Configuration) extends controllers.common.SharedResources(errorHandler, conf)