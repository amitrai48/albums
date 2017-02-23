package com.amitrai48.controllers

import akka.http.scaladsl.server.Directives._
import spray.json.{JsArray, JsNumber, JsObject, JsString}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.model.StatusCodes
import com.amitrai48.models.Album
import com.amitrai48.protocols.AlbumProtocol
import com.amitrai48.services.{AlbumService, AlbumServiceImpl}

/**
  * Created by amit on 21/2/17.
  */
class AlbumController extends AlbumProtocol{
  val albumService = new AlbumServiceImpl

  //create the schema for the in memory h2 DB
  albumService.createAlbumSchema

  def route = path("api" / "albums") {
    get {
      onSuccess(albumService.getAlbums){albums =>
        complete(albums)
      }
    } ~
    post {
      entity(as[Album]){album =>
        onSuccess(albumService.create(album)){id =>
          complete(StatusCodes.Created)
        }
      }
    } ~
    put{
      entity(as[Album]){album =>
        onSuccess(albumService.update(album)){updatedAlbum =>
          complete(updatedAlbum)
        }
      }
    }
  } ~
  path("api" / "albums" / LongNumber){ id =>
    onSuccess(albumService.delete(id)){_ =>
      complete(StatusCodes.OK)
    }
  }
}
