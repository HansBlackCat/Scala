package example
import org.apache.spark._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SaveMode

object RDDSimple extends App {
  // Init SparkConf
  val conf = new SparkConf().setAppName("RDDSample").setMaster("local")
  // Init SparkContext
  val sc = new SparkContext(conf)
  // Init SparkSession
  val spark = SparkSession.builder.appName("RDDSample").getOrCreate()

  val rawBlocks = sc.textFile("linkage")
  val noHeader = rawBlocks.filter(!isHeader(_))
  // rawBlocks.count == (Long = 5749142)                                                            
  // noHeader.count == (Long = 5749132)
  
  // Constructing DataFrame
  val prev = spark.read.csv("linkage") //prev.show to preview
  // parsed
  val parsed = spark.read.
    option("header", "true").
    option("nullValue", "?").
    option("inferSchema", "true").
    csv("linkage")
  parsed.filter((x) => !isHeader(x.toString))
  // parsed.printSchema
  
  // Other format
  // val d1 = spark.read.json("practice.json")
  // d1.write.mode(SaveMode.Ignore).json("pratice_write.json")

  parsed.cache()
  val dft1 = parsed.rdd.map(_.getAs[Boolean]("is_match")).countByValue() // Map(true -> 20931, false -> 5728206) 
  // val dft2 = parsed.groupBy("is_match").count.orderBy($"count".desc) // .show
  // - average, -sample standard deviation (stddev_pop == -population ~)
  // val dft3 = parsed.agg(avg($"cmp_sex"), stddev($"cmp_sex")) // .show

  // SQL
  {
    // parsed.createOrReplaceTempView("linkage")
    /*
    spark.sql("""
         SELECT is_match, COUNT(*) cnt
         FROM linkage
         GROUP BY is_match
         ORDER BY cnt DESC
       """).show
    */
  }

  //Summary
  val summary = parsed.describe() //.show
  val summary_select = summary.select("summary", "cmp_fname_c1", "cmp_fname_c2") // .show

  // Util func
  def isHeader(s: String) = {
    s.contains("id_1")
  }

  println(noHeader.first)
}