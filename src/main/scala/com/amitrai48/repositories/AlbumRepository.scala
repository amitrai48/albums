package com.amitrai48.repositories

import com.amitrai48.models.Album

/**
  * Created by amit on 23/2/17.
  */
trait AlbumRepository {
  def create(album: Album): Album
  def update(album: Album): Album
  def delete(album: Album): Unit
  def getAlbums: Seq[Album]
}
