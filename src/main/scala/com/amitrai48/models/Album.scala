package com.amitrai48.models

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

/**
  * Created by amit on 21/2/17.
  */
case class Album(name: String, artist: String, year: Int)

object Album extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val albumJF = jsonFormat3(Album.apply)
}