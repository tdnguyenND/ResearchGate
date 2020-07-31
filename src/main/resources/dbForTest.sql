drop database researchGate;
create database researchGate;
use researchGate;
create table Student (
                         first_name varchar(20) not null,
                         last_name varchar(20) not null,
                         user_id int not null,
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
/*Data for table Users */
insert into Student (first_name,last_name,user_id,address,date_of_birth,gender,phone_number,email,academic_level,training_place,achievement,forte,hobbits) values
('Đặng','Huy','18020313','261 Nguyễn Ngọc Vũ','2000-09-29','nam','0969936543','18020313@vnu.edu.vn','university','88 Phạm Văn Đồng',NULL,'Có Quy Tắc','Nghe nhạc'),
('Quang','Bình','18020217','26 Lê Thanh Nghị','2000-06-15','nam','0972282969','18020217@vnu.edu.vn','university','1 Trần Quốc Toản','Toeic 650','Kỹ năng làm việc nhóm','Chơi game'),
('Văn','Huy','18022317','1 Phạm Văn Đồng','2000-05-30','nam','0969652714','18022317@vnu.edu.vn','university',NULL,NULL,'Linh Hoạt','Chơi game'),
('Trường','Vũ','18020056','681 Phạm Tuấn Tài','2000-12-18','nam','0123656732','18020056@vnu.edu.vn','university','26 Hồ Tùng Mậuu','Ielts 6.5',null,'Đá bóng'),
('Thị','Dịu','18020213','KTX Mễ Trì','2000-09-26','nữ','0972906833','18020213@vnu.edu.vn','university',NULL,NULL,'Nhanh nhẹn','Hát'),
('Văn','Mạnh','18020001','19 Lương Thế Vinh','2000-02-26','nam','0969888732','18020001@vnu.edu.vn','university',NULL,NULL,NULL,'Xem phim'),
('Huy','Đông','18020101','1952 Láng','2000-10-20','nam','0972787634','18020101@vnu.edu.vn','university','291 Cầu Giấy',NULL,'Giao tiếp tốt','Nghe nhạc'),
('Quang','Minh','18020399','110 Trần Duy Hưng','2000-03-09','nam','0969503965','18020399@vnu.edu.vn','university',NULL,NULL,'Chăm chỉ','Đá bóng'),
('Thu','Trang','18021234','43 Tam Trinh','2000-01-10','nữ','0972059690','18021234@vnu.edu.vn','university','68 Trần Phú',NULL,NULL,'Du lịch'),
('Thu','Hằng','18020952','406 Thái Hà','2000-11-15','nữ','0123638744','18020952@vnu.edu.vn','university',NULL,NULL,'Hòa đồng','Mua sắm')
;

create table Account(
                        user_id int not null auto_increment,
                        username varchar(20) not null ,
                        password varchar(20) not null,
                        role varchar(20),
                        primary key(user_id)
);
/* Data for table Account*/
insert into Account(user_id,username,password,role) values
('18020313','HuyDang','huy18020313',NULL),
('18020217','QuangBinh','binh6969hn',NULL),
('18022317','VanHuy','huy6886TB',NULL),
('18020056','TruongVu','vu7777TB',NULL),
('18020213','ThiDiu','diuvu213TB',NULL),
('18020001','VanManh','manh1234HN',NULL),
('18020101','HuyDong','dong0101BG',NULL),
('18020399','QuangMinh','quangminh68BG',NULL),
('18021234','ThuTrang','trang1234ND',NULL),
('18020952','ThuHang','Hang0952HD',NULL)
;
create table ProgrammingLanguage(
                                    user_id int not null,
                                    prolan_id int not null,
                                    programming_language varchar(50) not null,
                                    foreign key (user_id) references Student(user_id)
);
/*Data for table ProgrammingLanguages 
	C 01
    C++ 02
    Java 03
    Js 04
    Ruby 05
    php 06
    C# 07
    Python 08
    TypeScript 09
    Shell 10
*/
insert into ProgrammingLanguage (user_id,prolan_id,programming_language) values
('18020313','01','C'),
('18020217','05','Ruby'),
('18022317','06','PHP'),
('18020056','03','Java'),
('18020213','02','C++'),
('18020001','04','JavaScript'),
('18020101','10','Shell'),
('18020399','07','C#'),
('18021234','09','TypeScript'),
('18020952','08','Python')
;
create table Company(
                        name_company varchar(50) not null,
                        company_id int not null,
                        address varchar(100) not null,
                        hotlines varchar(50) not null,
                        email varchar(50) not null,
                        salary varchar(100) not null,
                        career_level varchar(100) not null,
                        request varchar(1000) ,
                        entitlements varchar(1000) not null,
                        type_of_work varchar(100) not null,
                        primary key(id_company)
);
/* Data for table Company */
insert into Company(name_company,company_id,address,hotlines,email,salary,career_level,request,entitlements,type_of_work) values
('CÔNG TY TNHH DEVMOBA ','1002','Tố Hữu - La Khê - Hà Đông - Hà Nội','19005188','devmobatuyendung@gmail.com.vn','4.000.000 VNĐ-6.000.000 VNĐ','Fresher','từng làm đồ án web sử dụng ASP.NET MVC, Entity Framework ;năng động, sáng tạo, ham học hỏi,...','tăng lương cơ bản 2 lần/năm,Thưởng tết và các dịp lễ, du lịch hằng năm theo chế độ của công ty,...','Fulltime'),
('Công ty TNHH Thương Mại Và Dịch Vụ Tường Đan ','1032','Khu Đô Thị Mới Đại Kim, Phường Đại Kim , Quận Hoàng Mai , Hà Nội','19007227','tuongdantuyendung@gmail.com.vn','10,000,000 VNĐ - 15,000,000 VNĐ MONTH','Fresher','Nắm vững và thành thạo ngôn ngữ lập trình web php, javascript, html,css; Có tư duy logic tốt, đam mê yêu thích công việc lập trình, chủ động trong công việc','tăng lương 2 lần /năm,du lịch hàng năm,...','Fulltime'),
('Công TY TNHH BuCA - Hà Nội','1905','Nguyễn Phong Sắc, Cầu Giấy ,Hà Nội','19005777','bucatuyendung@gmail.com.vn','2.000.000 - 4.000.000 VNĐ','Fresher','từng làm dự án , bài tập lớn sử dụng Ruby,PHP,...','có tháng lương thứ 13, tăng lương 6 tháng 1 lần, được đi du lịch hàng năm','Fulltime')
;
create table CV(
	 cv_id int not null,
   	 user_id int not null,
   	 company_id int not null,
    	career_objective varchar(1000) not null,
    	experience varchar(1000) not null,
    	english_levels varchar(1000) ,
    	primary key(cv_id),
    	foreign key (user_id) references Users(user_id),
    	foreign key (company_id) references Company(company_id)
);
/* data for table CV */
insert into CV(cv_id,user_id,company_id,career_objective,experience,english_levels) values
('2001','18020313','1002','Học hỏi thêm kiến thức và cách xử lý trong công việc , nâng cao kỹ năng ,...','Thực tập sinh tại công ty Misa , tham gia dự án cùng giảng viên đại học','Toeic 450'),
('2002','18020213','1032','thăng tiếng trong công việc, ...','tham gia thực tập và nhiều dự án thực tế với giảng viên','Ielts 7.5'),
('2003','18020101','1905','mong muốn thắng tiến cùng với mức lương cao hơn , phát triển các kĩ năng mềm,...','kinh nghiệm làm việc tại Web88 1 năm và các dự án cùng giảng viên',NULL)
;
