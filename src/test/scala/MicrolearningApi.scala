import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilderBase
import io.gatling.http.Predef._

object MicrolearningApi {



  val createCategory = (feeder: FeederBuilderBase[String]#F) => exec(feed(feeder))
    .exec(http("create category")
      .post("http://localhost:8090/api/v1/microlearning/categories?name=${category}")
      .check(status.is(201))
    )

  val getArticles = exec()
    .exec(http("get wiki pages")
      .get("http://localhost:3000")
      .check(status.is(200))
    )

}
