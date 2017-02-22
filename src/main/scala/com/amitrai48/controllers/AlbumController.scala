package com.amitrai48.controllers

import akka.http.scaladsl.server.Directives._
import spray.json.{JsArray, JsNumber, JsObject, JsString}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import com.amitrai48.services.{AlbumService, AlbumServiceImpl}
/**
  * Created by amit on 21/2/17.
  */
class AlbumController {
  val albumService = new AlbumServiceImpl
  def route = path("api" / "albums") {
    get {
      val data = albumService.getAlbums
      complete(data)
    }
  }
}
