import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

class UsersPerSecondScenario extends Simulation{

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

  setUp(basicScenario.inject(constantUsersPerSec(2)during(100)))
}
