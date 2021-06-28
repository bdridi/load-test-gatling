import io.gatling.core.Predef.{array2FeederBuilder, configuration}


object CategoryFeeder {

  val feeder = Array(
    Map("category" -> "test"),
    Map("category" -> "kube"),
    Map("category" -> "cncf"),
    Map("category" -> "galing"),
    Map("category" -> "github"),
    Map("category" -> "sport"),
    Map("category" -> "art")
  ).circular

}
