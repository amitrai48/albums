package com.amitrai48.services

import com.amitrai48.models.Album
import com.amitrai48.repositories.AlbumRepository

/**
  * Created by amit on 21/2/17.
  */
trait AlbumService {
  val albumRepository: AlbumRepository

  def getAlbums: Seq[Album]
  def create(album: Album): Album
  def delete(album: Album): Unit
  def update(album: Album): Album
}
