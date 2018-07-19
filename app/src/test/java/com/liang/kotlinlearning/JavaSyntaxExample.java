package com.liang.kotlinlearning;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JavaSyntaxExample {

	// 获取学生的语文和数学成绩
	@Test
	public void testExampleByJunior() {
		// 从服务端获取数据
		Student feifei = getStudentByName("feifei");
		// 打印当前学生的语文和数学课程的分数
		List<Course> courses = feifei.getRecentExamination().getCourses();
		for (int i = 0; i < courses.size(); i++) {
			Course course = courses.get(i);
			if (course.getName().equals("Chinese")
					|| course.getName().equals("Math")) {
				System.out.println("学生:" + feifei.getName() + ";" +
						course.getName() + "分数:" + course.getScore());
			}
		}
	}

	// 结果1
	// 学生:feifei;Math分数:99.0
	// 学生:feifei;Chinese分数:null

	// 结果2
	// java.lang.NullPointerException

	@Test
	public void testExampleBySenior() {
		// 从服务端获取数据
		Student feifei = getStudentByName("feifei");
		// 打印当前学生的语文和数学课程的分数
		if (feifei == null
				|| feifei.getRecentExamination() == null
				|| feifei.getRecentExamination().getCourses() == null
				|| feifei.getRecentExamination().getCourses().isEmpty()) {
			// 增加了繁琐的判空处理
			System.out.println("学生: feifei;没有记录");
		} else {
			for (Course course : feifei.getRecentExamination().getCourses()) {
				if (course.getName().equals("Chinese")
						|| course.getName().equals("Math")) {
					// 增加了判空处理
					String scoreDesc = "没有记录";
					if (course.getScore() != null) {
						scoreDesc = course.getScore().toString();
					}
					System.out.println("学生:" + feifei.name + ";"
							+ course.name + "分数:" + scoreDesc);
				}
			}
		}
	}


	// 结果1
	// 学生:feifei;Math分数:99.0
	// 学生:feifei;Chinese分数:没有记录

	// 结果2
	// 学生: feifei;没有记录

	@Nullable
	private Student getStudentByName(String name) {
		List<Course> courses = Arrays.asList(new Course("Math", 99f),
				new Course("English", 30f),
				new Course("Chinese", null));
		double random = Math.random();
		System.out.println("random->" + random);
		if (random > 0.7) {
			return new Student(name, new Examination("midterm", courses));
		} else if (random > 0.4) {
			return new Student(name, new Examination("midterm", null));
		} else {
			return null;
		}
	}

	public class Examination {
		private String type;
		private List<Course> courses;

		public Examination(String type, List<Course> courses) {
			this.type = type;
			this.courses = courses;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Examination)) return false;
			Examination that = (Examination) o;
			return Objects.equals(getType(), that.getType()) &&
					Objects.equals(getCourses(), that.getCourses());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getType(), getCourses());
		}

		@Override
		public String toString() {
			return "Examination{" +
					"type='" + type + '\'' +
					", courses=" + courses +
					'}';
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
		private Examination recentExamination;

		public Student(String name, Examination recentExamination) {
			this.name = name;
			this.recentExamination = recentExamination;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Examination getRecentExamination() {
			return recentExamination;
		}

		public void setRecentExamination(Examination recentExamination) {
			this.recentExamination = recentExamination;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Student)) return false;
			Student student = (Student) o;
			return Objects.equals(getName(), student.getName()) &&
					Objects.equals(getRecentExamination(), student.getRecentExamination());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getName(), getRecentExamination());
		}

		@Override
		public String toString() {
			return "Student{" +
					"name='" + name + '\'' +
					", recentExamination=" + recentExamination +
					'}';
		}
	}
}

