package com.amitrai48.services

import com.amitrai48.models.Album
import com.amitrai48.repositories.AlbumRepository

import scala.concurrent.Future

/**
  * Created by amit on 21/2/17.
  */
trait AlbumService {
  val albumRepository: AlbumRepository

  def createAlbumSchema: Future[Unit]
  def getAlbums: Future[Seq[Album]]
  def create(album: Album): Future[Long]
  def delete(id: Long): Future[Int]
  def update(album: Album): Future[Album]
}
