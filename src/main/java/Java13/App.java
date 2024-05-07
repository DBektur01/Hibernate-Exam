package Java13;

import Java13.entity.*;
import Java13.service.*;
import Java13.service.serviceImpl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerLn = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
        System.out.println(""" 
                1. Student - Course
                2. UserDetails - UserProfile
                3. BlogPost - Comment
                """
    );
        switch( scannerNum.nextInt() ) {
            case 1 -> {
                CourseService courseService = new CourseServiceImpl();
                StudentService studentService = new StudentServiceImpl();
                boolean isTrueStudent=true;
                while (isTrueStudent) {
                    System.out.println("""
                            ----------------- Course -----------------
                            1.Создать курс
                            2.Получить курс по ID
                            3.Обновить курс по ID
                            4.Удалить курс
                            5.Получить всех студентов курса
                            6.Записать студента в курс
                            ----------------- Student -----------------
                            7.Создать студента
                            8.Получить студента по ID
                            9.Обновить студента по ID
                            10.Удалить студента
                            11.Получить все курсы студента
                            12.Получить студентов по недавним зачислениям
                            0.Exit
                            """);

                    switch (scannerNum.nextInt()) {
                        case 1 -> {
                            System.out.println("Введите название курса: ");
                            String name = scannerLn.nextLine();

                            System.out.println("Введите описание курса: ");
                            String description = scannerLn.nextLine();

                            System.out.println(courseService.createCourse(new Course(name, description, new ArrayList<>())));
                        }
                        case 2 -> {
                            System.out.println("Введите ID курса которого хотите найти: ");
                            Long courseId = scannerNum.nextLong();

                            System.out.println(courseService.getCourseById(courseId));
                        }
                        case 3 -> {
                            System.out.println("Введите ID курса которого хотите обновить: ");
                            Long courseId = scannerNum.nextLong();

                            System.out.println("Введите новое название курса: ");
                            String name = scannerLn.nextLine();

                            System.out.println("Введите новое описание курса: ");
                            String description = scannerLn.nextLine();

                            System.out.println(courseService.updateCourse(courseId, new Course(name, description)));
                        }
                        case 4 -> {
                            System.out.println("Введите ID курса которого хотите удалить: ");
                            Long courseId = scannerNum.nextLong();

                            System.out.println(courseService.deleteCourse(courseId));
                        }
                        case 5 -> {
                            System.out.println("Введите ID курса: ");
                            Long courseId = scannerNum.nextLong();

                            System.out.println(courseService.getCourseStudents(courseId));
                        }
                        case 6 -> {
                            System.out.println("Введите ID курса: ");
                            Long courseId = scannerNum.nextLong();

                            System.out.println("Введите ID студента: ");
                            Long studentId = scannerNum.nextLong();

                            System.out.println(courseService.assignStudentToCourse(courseId, studentId));
                        }
                        case 7 -> {
                            System.out.println("Введите полное имя студента: ");
                            String fullName = scannerLn.nextLine();

                            System.out.println("Введите email студента: ");
                            String email = scannerLn.nextLine();

                            System.out.println("Введите дату поступления на работу (yyyy mm dd): ");
                            LocalDate enrollmentDate = LocalDate.of(scannerNum.nextInt(), scannerNum.nextInt(), scannerNum.nextInt());

                            System.out.println(studentService.createStudent(new Student(fullName, email, enrollmentDate)));
                        }
                        case 8 -> {
                            System.out.println("Введите ID студента которого хотите найти: ");
                            Long studentId = scannerNum.nextLong();

                            System.out.println(studentService.getStudentById(studentId));
                        }
                        case 9 -> {
                            System.out.println("Введите ID студента которого хотите обновить: ");
                            Long studentId = scannerNum.nextLong();

                            System.out.println("Введите новое имя и фамилию для студента: ");
                            String newName = scannerLn.nextLine();

                            System.out.println(studentService.updateStudentName(studentId, newName));
                        }
                        case 10 -> {
                            System.out.println("Введите ID студента которого хотите удалить: ");
                            Long studentId = scannerNum.nextLong();

                            System.out.println(studentService.deleteStudent(studentId));
                        }
                        case 11 -> {
                            System.out.println("Введите ID студента: ");
                            Long studentId = scannerNum.nextLong();

                            System.out.println(studentService.getStudentCourses(studentId));
                        }
                        case 12 -> {
                            System.out.println("Введите лимит для студентов: ");
                            int limit = scannerNum.nextInt();

                            System.out.println(studentService.getStudentsByRecentEnrollments(limit));
                        }
                        case 0 ->{
                            isTrueStudent=false;
                        }
                    }
                }
            }
            case 2 -> {
                UserProfileService userProfileService = new UserProfileServiceImpl();
                UserDetailsService userDetailsService = new UserDetailsServiceImpl();

                boolean isTrueUser=true;
                while (isTrueUser) {
                    System.out.println("""
                                    ---------UserProfile-------
                                    1.Сохраняем Профиль Пользователя
                                    2.Получаем Профиль Пользователя
                                    3.Обновляем
                                    4.Удаляем
                                    5.Находим Пользователя По Электронной Почте
                                    6.Получаем Пользователя После Даты Регистрации
                                    -----------UserDetails--------
                                    7.Сохраняем Данные пользователя
                                    8.Получаем Данные Пользователя
                                    9.Обновляем Адрес
                                    10.Удаляем
                                    11.Получить информацию О Пользователе По Адресу
                                    12.Отсортировать информацию О Пользователе ПО дате рождения
                                    0.Exit
                            """);

                    switch (new Scanner(System.in).nextInt()) {
                        case 1 -> {
                            UserProfile userProfile = UserProfile.builder().user_name(new Scanner(System.in).next()).email(new Scanner(System.in).next()).registration_date(LocalDate.now()).build();
                            System.out.println(userProfileService.saveUserProfile(userProfile));
                        }
                        case 2 -> {
                            System.out.println(userProfileService.getUserProfileById(new Scanner(System.in).nextLong()));
                        }
                        case 3 -> {
                            Scanner sc = new Scanner(System.in);
                            System.out.println("Выберите ID профиля дома");
                            Long id = sc.nextLong();
                            System.out.println("Введите новое имя пользователя :");
                            String newName = sc.next();
                            System.out.println("Введите новый адрес электронной почты");
                            String newEmail = sc.next();
                            System.out.println("Введите новую дату регистрации (yyyy-MM-dd):");
                            LocalDate newreg = LocalDate.parse(sc.nextLine());

                            UserProfile userProfile = new UserProfile();
                            userProfile.setUser_name(newName);
                            userProfile.setEmail(newEmail);
                            userProfile.setRegistration_date(newreg);
                            System.out.println(userProfileService.updateUserProfile(id, userProfile));
                        }
                        case 4 -> {
                            userProfileService.deleteUserProfileById(new Scanner(System.in).nextLong());
                        }
                        case 5 -> {
                            userProfileService.getUserProfileByEmail((new Scanner(System.in).next()));
                        }
                        case 6 -> {
                            System.out.println("Введите дату регистрации (yyyy-MM-dd):");
                            System.out.println(userProfileService.getUserRegisteredAfterDate(LocalDate.now()));
                        }
                        case 7 -> {
                            UserDetails userDetails = UserDetails.builder().full_name(new Scanner(System.in).next()).date_of_birth(LocalDate.now()).address(new Scanner(System.in).next()).build();
                            System.out.println(userDetailsService.saveUserDetailToUserPById(new Scanner(System.in).nextLong(), userDetails));
                        }
                        case 8 -> {
                            System.out.println(userDetailsService.getUserDById(new Scanner(System.in).nextLong()));
                        }
                        case 9 -> {
                            Scanner sc = new Scanner(System.in);
                            System.out.println("Введите новый адрес:");
                            String newAddress = sc.next();
                            UserDetails userDetails = new UserDetails();
                            userDetails.setAddress(newAddress);
                            System.out.println(userDetailsService.updateAddressUserDetails(new Scanner(System.in).nextLong(), newAddress));
                        }
                        case 10 -> {
                            userDetailsService.deleteUserDById(new Scanner(System.in).nextLong());
                            ;
                        }
                        case 11 -> {
                            System.out.println(userDetailsService.getUserDetailsByAddress(new Scanner(System.in).next()));
                        }
                        case 12 -> {
                            System.out.println(userDetailsService.sortUserDetailsByDateOfBirth());
                        }
                        case 0->{
                            isTrueUser=false;
                        }
                    }

                }
            }
            case 3 -> {
                BlogPostService blogPostService = new BlogPostServiceImpl();
                CommentService commentService = new CommentServiceImpl();
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.print("""
                            1.Blog post
                            2.Comment
                            """
                    );
                    switch (scanner.nextInt()) {
                        case 1:
                            boolean while1 = true;
                            while (while1) {
                                try {
                                    System.out.println("""
                                            1.Добавьте запись в блоге
                                            2.Найдите запись в блоге по идентификатору
                                            3.Обновите запись в блоге по идентификатору
                                            4.Удалите запись в блоге по идентификатору
                                            5.Найдите все записи в блоге
                                            6.Найдите ключевое слово для записи в блоге
                                            0.Exit
                                            """);
                                    switch (scanner.nextInt()) {
                                        case 1 ->
                                                System.out.println(blogPostService.saveBlogPost(new BlogPost("Intagram", "true", LocalDate.of(2019, 1, 1))));
                                        case 2 -> System.out.println(blogPostService.getBlogPostById(1L));
                                        case 3 -> System.out.println(blogPostService.updateBlogPostById(1L, "false"));
                                        case 4 -> System.out.println(blogPostService.deleteBlogPostById(2L));
                                        case 5 -> System.out.println(blogPostService.getAllBlogPost());
                                        case 6 -> System.out.println(blogPostService.searchBlogPostByKeyword(1L));
                                        case 0 -> while1 = false;
                                        default -> System.out.println("Not-Correct!");
                                    }
                                } catch (RuntimeException e) {
                                    System.err.println(e.getMessage());
                                }
                            }
                            break;
                        case 2:
                            boolean while2 = true;
                            while (while2) {
                                try {
                                    System.out.println("""
                                           1.Добавьте комментарий по идентификатору записи в блоге
                                           2.Получите комментарий по идентификатору
                                           3.Обновите комментарий по идентификатору
                                           4.Удалите комментарий по идентификатору
                                           5.Отсортируйте комментарий по году публикации
                                           6.Сгруппируйте комментарий по сообщению
                                            0.Exit
                                            """);
                                    switch (scanner.nextInt()) {
                                        case 1 -> {
                                            System.out.println("Введите ID, к какой записи в блоге добавить комментария: ");
                                            Long id = scanner.nextLong();
                                            System.out.println(commentService.saveCommentByBlogPostId(id, new Comment("Hello", LocalDate.of(2025, 1, 2))));
                                        }
                                        case 2 -> System.out.println(commentService.getCommentById(1L));
                                        case 3 ->
                                                System.out.println(commentService.updateCommentTextById(1L, "gudBay"));
                                        case 4 -> System.out.println(commentService.deleteComment(1L));
                                        case 5 -> System.out.println(commentService.sortByPublisherDate("desc"));
                                        case 6 -> System.out.println(commentService.groupCommentsByPost(1L));
                                        case 0 -> while2 = false;
                                        default -> System.out.println("Not Number !");
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        default:
                            System.err.println("Error");

                    }
                }
            }
        }

        }

    }
}
