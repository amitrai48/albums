package com.amitrai48.errors

import akka.http.scaladsl.model.StatusCode

/**
  * Created by amit on 23/2/17.
  */
case class ServiceError(status: StatusCode, code: String, description: String) extends Exception {

}
