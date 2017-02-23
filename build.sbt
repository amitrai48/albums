name := "akka-http-album"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  val slickV = "3.1.1"
  val akkaHttpV = "10.0.3"
  Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV,
    "com.typesafe.slick" %% "slick" % slickV,
    "com.typesafe.slick" %% "slick-hikaricp" % slickV,
    "com.h2database" % "h2" % "1.3.175"
  )
}