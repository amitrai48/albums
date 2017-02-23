package com.amitrai48.services
import com.amitrai48.models.Album
import com.amitrai48.repositories.{AlbumRepository, AlbumRepositoryImpl}

/**
  * Created by amit on 21/2/17.
  */
class AlbumServiceImpl extends AlbumService {
  override val albumRepository: AlbumRepository = new AlbumRepositoryImpl
  override def getAlbums: Seq[Album] = {
    albumRepository.getAlbums
  }

  override def create(album: Album): Album = {
    albumRepository.create(album)
  }

  override def delete(album: Album): Unit = {
    albumRepository.delete(album)
  }

  override def update(album: Album): Album = {
    albumRepository.update(album)
  }
}
