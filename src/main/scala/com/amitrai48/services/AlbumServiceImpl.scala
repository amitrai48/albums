package com.amitrai48.services
import com.amitrai48.models.Album
import com.amitrai48.repositories.{AlbumRepository, AlbumRepositoryImpl}
import slick.driver.H2Driver.api._

import scala.concurrent.Future

/**
  * Created by amit on 21/2/17.
  */
class AlbumServiceImpl extends AlbumService {
  override val albumRepository: AlbumRepository = new AlbumRepositoryImpl
  val db = Database.forConfig("h2db.db")

  override def createAlbumSchema: Future[Unit] = {
    db.run(albumRepository.createAlbumSchema)
  }

  override def getAlbums: Future[Seq[Album]] = {
    db.run(albumRepository.getAlbums)
  }

  override def create(album: Album): Future[Long] = {
    db.run(albumRepository.create(album))
  }

  override def delete(id: Long): Future[Int] = {
    db.run(albumRepository.delete(id))
  }

  override def update(album: Album): Future[Album] = {
    db.run(albumRepository.update(album))
  }
}
