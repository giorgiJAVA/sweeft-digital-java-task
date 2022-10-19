CREATE TABLE Teacher(
	first_name VARCHAR NOT NULL,
	last_name VARCHAR NOT NULL,
	sex VARCHAR NOT NULL,
	subject VARCHAR NOT NULL,
	teacher_id SERIAL PRIMARY KEY
);

CREATE TABLE Pupil(
	first_name VARCHAR NOT NULL,
	last_name VARCHAR NOT NULL,
	sex VARCHAR NOT NULL,
	_class INTEGER NOT NULL,
	pupil_id SERIAL PRIMARY KEY
);

CREATE TABLE teacher_to_pupil(
	teacher_id INTEGER NOT NULL,
	FOREIGN KEY(teacher_id) REFERENCES Teacher(teacher_id),
	pupil_id INTEGER NOT NULL,
	FOREIGN KEY(pupil_id) REFERENCES Pupil(pupil_id)
);

INSERT INTO teacher VALUES('მაკა' , 'მაკაშვილი' , 'F' , 'ბიოლოგია'),
                          ('ნინო' , 'ნინოშვილი' , 'F' , 'ფიზიკა'), 
                          ('ანა' , 'ანაშვილი' , 'F' , 'მათემატიკა');



INSERT INTO pupil VALUES('გიორგი' , 'გიორგიშვილი' , 'M' , 5),
                        ('ლაშა' , 'ლაშაშვილი' , 'M' , 7),
                        ('ანა' , 'ანიაშვილი' , 'F' , 12),
                        ('ვახო' , 'ვახოშვილი' , 'F' , 10);

INSERT INTO teacher VALUES('სოფო' , 'სოფოშვილი' , 'F' , 'ინგლისური');

INSERT INTO teacher_to_pupil VALUES(1,1),(2,2),(3,3),(4,4);

SELECT t.first_name , t.last_name , t.sex , t.subject
FROM Teacher t
INNER JOIN teacher_to_pupil ttp on t.teacher_id = ttp.teacher_id 
INNER JOIN pupil ON ttp.pupil_id = Pupil.pupil_id
WHERE pupil.first_name = 'გიორგი';

