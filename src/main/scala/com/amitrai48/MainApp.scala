package com.amitrai48

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.io.StdIn
import com.amitrai48.controllers.AlbumController
import spray.json._

/**
  * Created by amit on 21/2/17.
  */
object MainApp extends App {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher

  val route = new AlbumController().route

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8085)

  println(s"Server online at http://localhost:8085/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}
