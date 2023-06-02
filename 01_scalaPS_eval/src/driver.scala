
class Demo(
    override val profile: JdbcProfile = 

    val conn = new DBConnection(profile)
    
    def test: Unit = {
        conn.dbObject withSession { implicit session: Session =>    
        // create  table  selected environment
        try {
        employees.ddl.create
        } catch {
        case ex: Exception => println(ex.getMessage)
        }
        // insert employees into database
        employees.insert(Sample Data link)
        employees.insert(Sample Data link)
        println("======================retrieve from database ====================")
        
        }
    }
}

object DemoApp extends App {
(new Demo).test
}