create database researchGate;
use researchGate;
create table Student (
                         first_name varchar(20) not null,
                         last_name varchar(20) not null,
                         user_id int not null auto_increment,
                         address varchar(100) not null,
                         date_of_birth date not null,
                         gender varchar(10) not null,
                         phone_number varchar(50) not null,
                         email varchar(50) not null,
                         academic_level varchar (50) not null,
                         training_place varchar(100) ,
                         achievement varchar(100) ,
                         forte varchar(100) ,
                         hobbits varchar(100) ,
                         primary key(user_id)
);
/*Data for table Student */
insert into Student (first_name,last_name,address,date_of_birth,gender,phone_number,email,academic_level,training_place,achievement,forte,hobbits) values
('Đặng','Huy','261 Nguyễn Ngọc Vũ','2000-09-29','nam','0969936543','18020313@vnu.edu.vn','university','88 Phạm Văn Đồng',NULL,'Có Quy Tắc','Nghe nhạc'),
('Quang','Bình','26 Lê Thanh Nghị','2000-06-15','nam','0972282969','18020217@vnu.edu.vn','university','1 Trần Quốc Toản','Toeic 650','Kỹ năng làm việc nhóm','Chơi game'),
('Văn','Huy','1 Phạm Văn Đồng','2000-05-30','nam','0969652714','18022317@vnu.edu.vn','university',NULL,NULL,'Linh Hoạt','Chơi game'),
('Trường','Vũ','681 Phạm Tuấn Tài','2000-12-18','nam','0123656732','18020056@vnu.edu.vn','university','26 Hồ Tùng Mậuu','Ielts 6.5',null,'Đá bóng'),
('Thị','Dịu','KTX Mễ Trì','2000-09-26','nữ','0972906833','18020213@vnu.edu.vn','university',NULL,NULL,'Nhanh nhẹn','Hát'),
('Văn','Mạnh','19 Lương Thế Vinh','2000-02-26','nam','0969888732','18020001@vnu.edu.vn','university',NULL,NULL,NULL,'Xem phim'),
('Huy','Đông','1952 Láng','2000-10-20','nam','0972787634','18020101@vnu.edu.vn','university','291 Cầu Giấy',NULL,'Giao tiếp tốt','Nghe nhạc'),
('Quang','Minh','110 Trần Duy Hưng','2000-03-09','nam','0969503965','18020399@vnu.edu.vn','university',NULL,NULL,'Chăm chỉ','Đá bóng'),
('Thu','Trang','43 Tam Trinh','2000-01-10','nữ','0972059690','18021234@vnu.edu.vn','university','68 Trần Phú',NULL,NULL,'Du lịch'),
('Thu','Hằng','406 Thái Hà','2000-11-15','nữ','0123638744','18020952@vnu.edu.vn','university',NULL,NULL,'Hòa đồng','Mua sắm')
;

create table Account(
                        user_id int not null auto_increment,
                        username varchar(20) not null ,
                        password varchar(20) not null,
                        role varchar(20) not null ,
                        primary key(user_id)
);
/* Data for table Account*/
insert into Account(username,password,role) values
('HuyDang','huy18020313','student'),
('QuangBinh','binh6969hn','student'),
('VanHuy','huy6886TB','student'),
('TruongVu','vu7777TB','student'),
('ThiDiu','diuvu213TB','student'),
('VanManh','manh1234HN','student'),
('HuyDong','dong0101BG','student'),
('QuangMinh','quangminh68BG','student'),
('ThuTrang','trang1234ND','student'),
('ThuHang','Hang0952HD','student')
;
create table ProgrammingLanguage(
                                    user_id int not null auto_increment,
                                    programming_language varchar(50) not null,
                                    primary key(user_id)
);
/*Data for table ProgrammingLanguages 
*/
insert into ProgrammingLanguage (programming_language) values
('C'),
('Ruby'),
('PHP'),
('Java'),
('C++'),
('JavaScript'),
('Shell'),
('C#'),
('TypeScript'),
('Python')
;
create table Company(
	name_company varchar(50) not null,
    user_id int not null auto_increment,
    address varchar(100) not null,
    hotlines varchar(50) not null,
    email varchar(50) not null,
    primary key(user_id)
);
/* Data for table Company */
insert into Company(name_company,address,hotlines,email) values
('CÔNG TY TNHH DEVMOBA ','Tố Hữu - La Khê - Hà Đông - Hà Nội','19005188','devmobatuyendung@gmail.com.vn'),
('Công ty TNHH Thương Mại Và Dịch Vụ Tường Đan ','Khu Đô Thị Mới Đại Kim, Phường Đại Kim , Quận Hoàng Mai , Hà Nội','19007227','tuongdantuyendung@gmail.com.vn'),
('Công TY TNHH BuCA - Hà Nội','Nguyễn Phong Sắc, Cầu Giấy ,Hà Nội','19005777','bucatuyendung@gmail.com.vn')
;
create table Recruitment(
	user_id int not null  auto_increment,
    career varchar(255) not null,
    amount int not null,
    salary varchar(255) not null,
    requirement varchar(1000) not null,
    advantage varchar(1000) not null,
    type_of_work varchar(100) not null,
    primary key(user_id)
);
insert into Recruitment(career,amount,salary,requirement,advantage,type_of_work) values
	('fresher','10','4,500,000 VNĐ',"từng làm đồ án web sử dụng ASP.NET MVC, Entity Framework ;năng động, sáng tạo, ham học hỏi,...","tăng lương cơ bản 2 lần/năm,Thưởng tết và các dịp lễ, du lịch hằng năm theo chế độ của công ty,...","Fulltime"),
    ('managers','5','20,000,000 VNĐ',"Nắm vững và thành thạo ngôn ngữ lập trình web php, javascript, html,css; Có tư duy logic tốt, đam mê yêu thích công việc lập trình, chủ động trong công việc","tăng lương 2 lần /năm,du lịch hàng năm,...","Fulltime"),
    ('fresher','30','6,000,000 VNĐ',"từng làm dự án , bài tập lớn sử dụng Ruby,PHP,...","có tháng lương thứ 13, tăng lương 6 tháng 1 lần, được đi du lịch hàng năm","Fulltime")
;
create table CV(
	user_id int not null auto_increment,
    experience varchar(1000) not null,
    foreign_language varchar(255) not null,
    social_activities varchar(1000) not null,
    special_skills varchar(1000) not null,
    job_goals varchar(1000) not null,
    primary key(user_id)
);
insert into CV(experience,foreign_language,social_activities,special_skills,job_goals) values
	('1 năm kinh nghiệm làm PHP, thành thạo HTML,CSS,JS','English','Dạy học cho trẻ em','Khả năng lãnh đạo','PHP developer'),
    ('Lập trình viên Android, lập trình ứng dụng di động','English','Ban điều hành tổ chức sinh viên','Làm việc nhóm','Học thêm lập trình IOS'),
    ('Thực hiện dự án với team dùng Laravel framework làm bankend','English','Trưởng nhóm ban đối ngoại','Lập kế hoạch cho từng quá trình','Trở thành 1 PM lead team 10 nhân sự'),
    ('Lập trình các addons cho website','English','Phó ban tình nguyện viên','Phát triển Module','Làm ra sản phẩm giúp ích cho công ty và kiếm nhiều tiền'),
    ('6 thàng làm chuyên viên an ninh mạng','English','Thành viên câu lạc bộ quản trị mạng','Tỉ mỉ, khả năng phân tích, nhận biết xu hướng, tư duy logic','Trở thành 1 kĩ sư an ninh mạng'),
    ('3 tháng kinh nghiệm phát triển ứng dụng','English','Trưởng nhóm câu lạc bộ thuyết trình','Làm việc tốt dưới áp lực','Trở thành 1 chuyên viên phát triển ứng dụng')
    

