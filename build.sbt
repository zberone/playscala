Common.appSettings(messagesFilesFrom = Seq("common", "admin", "web", "princegroup", "fiveramSite"))


lazy val common = (project in file("modules/common")).enablePlugins(PlayScala)

lazy val admin = (project in file("modules/admin")).enablePlugins(PlayScala).dependsOn(common)

lazy val web = (project in file("modules/web")).enablePlugins(PlayScala).dependsOn(common)

lazy val princegroup = (project in file("modules/princegroup")).enablePlugins(PlayScala).dependsOn(common)

lazy val fiveramSite = (project in file("modules/fiveramSite")).enablePlugins(PlayScala).dependsOn(common)

lazy val root = (project in file(".")).enablePlugins(PlayScala).aggregate(common, admin, web, princegroup, fiveramSite).dependsOn(common, admin, web, princegroup, fiveramSite)


libraryDependencies ++= Common.commonDependencies

scalariformSettings