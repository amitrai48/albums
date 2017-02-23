package com.amitrai48.protocols

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.amitrai48.models.Album
import spray.json.DefaultJsonProtocol

/**
  * Created by amit on 23/2/17.
  */
trait AlbumProtocol extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val albumJF = jsonFormat4(Album.apply)
}
