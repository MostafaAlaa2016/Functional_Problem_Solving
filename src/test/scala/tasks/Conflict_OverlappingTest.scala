package tasks

import org.scalatest.FunSuite

class Conflict_OverlappingTest extends FunSuite {

  test("count_overlapping_bookings") {

    val input = List(Conflict_Overlapping.Interval(2,4),Conflict_Overlapping.Interval(3,5))
    assert(Conflict_Overlapping.count_overlapping_bookings(input) === 2)
  }

}
