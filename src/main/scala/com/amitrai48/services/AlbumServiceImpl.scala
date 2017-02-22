package com.amitrai48.services
import com.amitrai48.models.Album

/**
  * Created by amit on 21/2/17.
  */
class AlbumServiceImpl extends AlbumService {
  override def getAlbums: Seq[Album] = {
    Seq(
      Album("DeathMagetic", "Metallica", 2003),
      Album("The Eminem SHow", "Eminem", 2006)
    )
  }
}
