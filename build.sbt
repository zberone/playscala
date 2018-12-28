Common.appSettings(messagesFilesFrom = Seq("common", "admin", "web", "princegroup"))


lazy val common = (project in file("modules/common")).enablePlugins(PlayScala)

lazy val admin = (project in file("modules/admin")).enablePlugins(PlayScala).dependsOn(common)

lazy val web = (project in file("modules/web")).enablePlugins(PlayScala).dependsOn(common)

lazy val princegroup = (project in file("modules/princegroup")).enablePlugins(PlayScala).dependsOn(common)



lazy val root = (project in file(".")).enablePlugins(PlayScala).aggregate(common, admin, web, princegroup).dependsOn(common, admin, web, princegroup)


libraryDependencies ++= Common.commonDependencies

scalariformSettings