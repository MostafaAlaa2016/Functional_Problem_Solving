package tasks

import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

object Conflict_Overlapping extends App {

  /** Interval case class contains the start and end intervals
    *
    * @param start : Int represent the start of the interval
    * @param end   : Int represent the end of the interval
    */
  case class Interval(start: Int, end: Int)


  /** count overlapping in bookings
    *
    * Count the distinct overlapping for input list of `Interval`
    * @param inputList : List[Interval] contains the booking details.
    * @return Int count of distinct overlapping bookings
    */
  def count_overlapping_bookings(inputList: List[Interval]): Int = {

    val inputListSorted = inputList.sortBy(_.start)
    var numberOfOverlapping = 0
    for (i <- 1 until inputListSorted.length)
      if (inputListSorted(i - 1).end > inputListSorted(i).start)
        numberOfOverlapping = numberOfOverlapping + inputListSorted(i - 1).end - inputListSorted(i - 1).start
    numberOfOverlapping
  }

  val numberOfBookings = readInt()


  var intervals = new ListBuffer[Interval]()

  for (_ <- 1 to numberOfBookings) {
    val Array(a, b) = readLine.split(" ").map(_.toInt)
    intervals += Interval(a, b)
  }

  val intervalsList = intervals.toList
  println(count_overlapping_bookings(intervalsList))

}
