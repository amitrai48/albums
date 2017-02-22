package com.amitrai48.services

import com.amitrai48.models.Album

/**
  * Created by amit on 21/2/17.
  */
trait AlbumService {
  def getAlbums: Seq[Album]
}
