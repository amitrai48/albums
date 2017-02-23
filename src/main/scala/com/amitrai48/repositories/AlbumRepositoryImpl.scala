package com.amitrai48.repositories
import com.amitrai48.MainApp
import com.amitrai48.models.Album

import scala.collection.mutable.ListBuffer
import slick.driver.H2Driver.api._
import slick.lifted.ProvenShape

/**
  * Created by amit on 23/2/17.
  */

class AlbumTable(tag: Tag) extends Table[Album](tag, "album") {
  def title = column[String]("title")
  def artist = column[String]("artist")
  def year = column[Int]("year")
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def * = (title, artist, year, id.?) <> (Album.tupled, Album.unapply)
}

class AlbumRepositoryImpl extends AlbumRepository {
  implicit val ec = MainApp.executionContext
  protected lazy val AlbumTable = TableQuery[AlbumTable]

  override def createAlbumSchema: DBIO[Unit] = {
    AlbumTable.schema.create
  }

  override def create(album: Album): DBIO[Long] = {
    //AlbumTable += album
    AlbumTable returning AlbumTable.map(_.id) += album
  }

  override def update(album: Album): DBIO[Album] = {
    AlbumTable.filter(_.id === album.id).update(album).map{
      case 1 => album
      case x => throw new Exception("Could not update album")
    }
  }

  override def delete(id: Long): DBIO[Int] = {
    AlbumTable.filter(_.id === id).delete.map{
      case 1 => 1
      case x => throw new Exception("Could not update album")
    }
  }

  override def getAlbums: DBIO[Seq[Album]] = {
    AlbumTable.result
  }
}
