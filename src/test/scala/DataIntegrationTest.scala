package playground

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import io.delta._

class DataIntegrationTest extends AnyFlatSpec with SparkTestContext with Matchers {

  it should "Create some files in the delta format" in {
      Data
  }
}