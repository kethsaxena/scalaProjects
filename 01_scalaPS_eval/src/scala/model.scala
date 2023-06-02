import scala.slick.driver.JdbcProfile

//DEFINE DRIVER 
trait Profile {
val profile: JdbcProfile
}

trait ModelComponent {
    this: Profile => import profile.simple._

    case class Row(id: String, cardType: String, processingRegion: String, amt: Int)
    
    class transactions(tag: Tag) extends Table[Row](tag, "Row") {
    def ID = column[String]("id", O.PrimaryKey , O.DBType("VARCHAR(100)"))
    def CardType = column[String]("name", O.NotNull, O.DBType("VARCHAR(100)"))
    def ProcessingRegion = column[String]("email", O.NotNull, O.DBType("VARCHAR(100)"))
    def amt = column[Int]("designation", O.NotNull, O.Default(0))

    def * = (ID, CardType, ProcessingRegion, amt) <> (Row.tupled, Row.unapply)
    }

    val transactions= TableQuery[transactions]
}