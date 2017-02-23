package com.amitrai48.repositories

import com.amitrai48.models.Album
import slick.dbio.DBIO

/**
  * Created by amit on 23/2/17.
  */
trait AlbumRepository {
  def create(album: Album): DBIO[Long]
  def update(album: Album): DBIO[Album]
  def delete(id: Long): DBIO[Int]
  def getAlbums: DBIO[Seq[Album]]
  def createAlbumSchema: DBIO[Unit]
}
