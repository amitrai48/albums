package com.amitrai48.repositories
import com.amitrai48.models.Album

import scala.collection.mutable.ListBuffer

/**
  * Created by amit on 23/2/17.
  */
class AlbumRepositoryImpl extends AlbumRepository {
  var albums: scala.collection.mutable.ListBuffer[Album] = ListBuffer()
  var id: Long = 0

  override def create(album: Album): Album = {
    id = id + 1
    val createdAlbum = album.copy(id= Some(id))
    albums += createdAlbum
    createdAlbum
  }

  override def update(album: Album): Album = {
    albums.find(_.id == album.id) match {
      case Some(a) =>
        val updatedAlbum = a.copy(name = album.name, artist = album.artist, year = album.year)
        val index = albums.indexOf(a)
        albums.remove(index)
        albums.append(updatedAlbum)
        updatedAlbum
      case None => throw new Exception("Album Not Found")
    }
  }

  override def delete(album: Album): Unit = {
    val index = albums.indexOf(album)
    if(index != -1)
      albums.remove(index)
    else
      throw new Exception("Album Not Found")
  }

  override def getAlbums: Seq[Album] = {
    albums
  }
}
