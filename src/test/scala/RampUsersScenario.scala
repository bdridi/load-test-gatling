import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

class RampUsersScenario extends Simulation{

    val basicScenario = scenario("demo")
      .repeat(10, "i") {
        exec(MicrolearningApi.createCategory(CategoryFeeder.feeder))
      }
      .exec(MicrolearningApi.getArticles)
      .repeat(10, "i") {
        exec(MicrolearningApi.createCategory(CategoryFeeder.feeder))
      }
      .exec(MicrolearningApi.getArticles)
      .repeat(10, "i") {
        exec(MicrolearningApi.createCategory(CategoryFeeder.feeder))
      }
      .exec(MicrolearningApi.getArticles)

  setUp(basicScenario.inject(rampUsers(100)during(100)))
}
