import com.exist.ecc.service.Ex1Service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;


class Ex1ServiceTest {
	Ex1Service A;
	@BeforeEach
	public void init(){

		A = new Ex1Service();
	}

	@Nested
	class StartFunctionTest{
		@Test
		public void rowsTest() {
			final int expectedRows = 3;
			final int actualRows = 3;
			assertEquals(expectedRows,actualRows);
		}

		@Test
		public void columnTest(){
			final int expectedCols= 3;
			final int actualCols = 3;
			assertEquals(expectedCols,actualCols);
		}
	}

	@Nested
	class SelectionTest{
		private int rows;
		private int columns;
		private int[][] arrayTesting;

		@BeforeEach
		public void init() {
			rows = 3;
			columns = 2;
			arrayTesting = new int[rows][columns];
		}

		@Test
		public void arrayRowsTest(){
			assertEquals(rows, arrayTesting.length);
		}

		@Test
		public void arrayColumnsTest(){
			assertEquals(columns, arrayTesting[0].length);
		}
	}
	@Test
	public void tableCreationTest() {
		int rows = 3;
		int columns = 2;
		String[][] table = A.createTable(rows, columns);
		assertTrue(table.getClass().isArray());
	}

	@Nested
	class tableTesting{
		String[][] table;
		@BeforeEach
		public void init(){
			table = new String[][]{
				{"aaa", "x123", "aaa3", "xC2)3"},
				{"aa1", "aa2aa", "aa4", "xCz)3"},
			};
			System.setOut(System.out);
		}

		@Test
		public void occurrence1Test(){
			int result = A.findOccurence1(table, '1');
			int expected = 2;
			assertEquals(expected, result);
		}

		@Test
		public void occurrence2Test(){
			int result = A.findOccurence2(table, "a1");
			int expected = 1;
			assertTrue(result!=0);
		}
		@Test
		public void occurrence3Test(){
			int result = A.findOccurence3(table, "aaa");
			int expected = 1;
			assertEquals(expected, result);
		}
		@Test
		public void displayTableTest(){
			String expected = " | [0][0] = aaa | [0][1] = x123 | [0][2] = aaa3 | [0][3] = xC2)3\n" +
					          " | [1][0] = aa1 | [1][1] = aa2aa | [1][2] = aa4 | [1][3] = xCz)3\n";
			String actual = A.displayTable(table);
			System.out.println(actual);
			assertEquals(expected, actual);
		}
	}
}
