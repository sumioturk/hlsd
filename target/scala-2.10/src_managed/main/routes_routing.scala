// @SOURCE:/Users/sean/Documents/workspace/hls/conf/routes
// @HASH:dcd7958c51f666a06407182f91f4730fdab7a21b
// @DATE:Mon Feb 11 14:56:59 JST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_musics1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("stream/musics/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:8
private[this] lazy val controllers_Application_musics2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("secure/musics/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:10
private[this] lazy val controllers_Application_user3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
        

// @LINE:14
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+"""))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stream/musics/$id<[^/]+>""","""controllers.Application.musics(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """secure/musics/$id<[^/]+>""","""controllers.Application.musics(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""controllers.Application.user"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_musics1(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Application.musics(id), HandlerDef(this, "controllers.Application", "musics", Seq(classOf[String]),"GET", """""", Routes.prefix + """stream/musics/$id<[^/]+>"""))
   }
}
        

// @LINE:8
case controllers_Application_musics2(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Application.musics(id), HandlerDef(this, "controllers.Application", "musics", Seq(classOf[String]),"GET", """""", Routes.prefix + """secure/musics/$id<[^/]+>"""))
   }
}
        

// @LINE:10
case controllers_Application_user3(params) => {
   call { 
        invokeHandler(controllers.Application.user, HandlerDef(this, "controllers.Application", "user", Nil,"GET", """""", Routes.prefix + """user"""))
   }
}
        

// @LINE:14
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        