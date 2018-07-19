package com.liang.kotlinlearning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JavaSyntax {


	public void testDefination() {
		final int a = 1;// 可变
		int b = 1;// 不可变
	}

	public void testPrintString() {
		String name = "feifei";
		int age = 18;
		System.out.print("name -> " + name + ",age ->" + age);
	}

	public void useKotlin() {
		// use object
		System.out.print(KotlinObject.PI);
		System.out.print(KotlinObject.INSTANCE.max(1, 2));

		// use class static const or fun
		System.out.print(KotlinClass.PI);
		System.out.print(KotlinClass.Companion.max(1, 2));
	}

	public String describe(Object obj) {
		if (obj instanceof Integer && (int) obj == 1) {
			return "One";
		} else if (obj.equals("Hello")) {
			return "Greeting";
		} else if (obj instanceof Long) {
			return "Long";
		} else if (!(obj instanceof String)) {
			return "Not a string";
		} else {
			return "Unknown";
		}
	}


//	fun describe(obj: Any): String =
//	when (obj) {
//		1 -> "One"
//		"Hello" -> "Greeting"
//		is Long -> "Long"
//		!is String -> "Not a string"
//                else -> "Unknown"
//	}

	// 获取学生的语文和数学成绩
	@Test
	public void testExampleByJunior() {
		// 从服务端获取数据
		Student feifei = getStudentByName("feifei");

		// 打印当前学生的语文和数学课程的分数
		List<Course> courses = feifei.getCourses();
		for (int i = 0; i < courses.size(); i++) {
			Course course = courses.get(i);
			if (course.getName().equals("Chinese")) {
				System.out.println("学生:" + feifei.name + ";" + "语文分数:" + course.getScore());
			}
			if (course.getName().equals("Math")) {
				System.out.println("学生:" + feifei.name + ";" + "数学分数:" + course.getScore());
			}
		}

		// 结果1
		// 学生:feifei;数学分数:99.0
		// 学生:feifei;语文分数:null

		// 结果2
		// java.lang.NullPointerException

//		for (Course course : feifei.getCourses()) {
//			if (course.getName().equals("Chinese") || course.getName().equals("Math")) {
//				System.out.println("学生:" + feifei.name + ";" + "数学分数:");
//			}
//		}
	}

	public Student getStudentByName(String name) {
		List<Course> courses = new ArrayList<>();
		courses.add(new Course("Math", 99f));
		courses.add(new Course("English", 30f));
		courses.add(new Course("Chinese", null));
		Student stu = new Student(name, 18, courses);

		if (Math.random() > 0.5) {
			return stu;
		} else {
			return null;
		}

	}


	public class Course {
		private String name;
		private Float score;

		public Course(String name, Float score) {
			this.name = name;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Float getScore() {
			return score;
		}

		public void setScore(Float score) {
			this.score = score;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Course)) return false;
			Course course = (Course) o;
			return Objects.equals(getName(), course.getName()) &&
					Objects.equals(getScore(), course.getScore());
		}

		@Override
		public int hashCode() {

			return Objects.hash(getName(), getScore());
		}

		@Override
		public String toString() {
			return "Course{" +
					"name='" + name + '\'' +
					", score=" + score +
					'}';
		}
	}

	public class Student {
		private String name;
		private Integer age;
		private List<Course> courses;

		public Student(String name, Integer age, List<Course> courses) {
			this.name = name;
			this.age = age;
			this.courses = courses;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}
	}
}

