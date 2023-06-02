import scala.slick.driver.JdbcProfile
import scala.slick.driver.MySQLDriver

object Driver {
    val DEV = "dev"
    val SIT = "sit"
    val SAT = "sat"
    val PROD = "prod"

    def getDriver: JdbcProfile = 
        {
            scala.util.Properties.envOrElse("runMode", "prod") 
            match {
                case DEV => MySQLDriver
                case SIT => MySQLDriver
                case SAT => MySQLDriver
                case PROD => MySQLDriver
                }
        }
}