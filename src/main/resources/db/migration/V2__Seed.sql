-- Seed initial data for users
INSERT INTO users (name, email, password, image) VALUES
('Alice Johnson', 'alice.johnson@example.com', 'password1', 'alice.jpg'),
('Bob Smith', 'bob.smith@example.com', 'password1', 'bob.jpg'),
('Charlie Brown', 'charlie.brown@example.com', 'password1', 'charlie.jpg'),
('Diana Prince', 'diana.prince@example.com', 'password1', 'diana.jpg'),
('Ethan Hunt', 'ethan.hunt@example.com', 'password1', 'ethan.jpg'),
('Fiona Gallagher', 'fiona.gallagher@example.com', 'password1', 'fiona.jpg'),
('George Orwell', 'george.orwell@example.com', 'password1', 'george.jpg'),
('Hannah Montana', 'hannah.montana@example.com', 'password1', 'hannah.jpg'),
('Ian Malcolm', 'ian.malcolm@example.com', 'password1', 'ian.jpg'),
('Julia Roberts', 'julia.roberts@example.com', 'password1', 'julia.jpg');


-- Seed initial data for doctors
INSERT INTO doctors (name, speciality, image, biography) VALUES
('Dr. Emily Carter', 'Cardiology', 'emily.jpg', 'Experienced cardiologist with a focus on preventative care.'),
('Dr. James Lee', 'Dermatology', 'james.jpg', 'Specializes in skin health and cosmetic dermatology.'),
('Dr. Sarah Wilson', 'Pediatrics', 'sarah.jpg', 'Dedicated pediatrician with over 10 years of experience.'),
('Dr. Michael Tan', 'Orthopedics', 'michael.jpg', 'Expert in bone and joint health with a passion for patient recovery.'),
('Dr. Olivia Green', 'Psychiatry', 'olivia.jpg', 'Compassionate psychiatrist with experience in anxiety and depression.'),
('Dr. Noah White', 'Neurology', 'noah.jpg', 'Neurologist specializing in brain and nervous system disorders.');

-- Seed initial data for appointments
INSERT INTO appointments (user_id, doctor_id, start_time, date, comment) VALUES
(1, 1, '09:00:00', '2024-11-01', 'Routine follow-up check.'),
(2, 2, '11:00:00', '2024-11-02', 'Consultation for skin care.'),
(3, 3, '14:00:00', '2024-11-03', 'First wellness visit for child.'),
(4, 1, '10:30:00', '2024-11-04', 'Cardiology consultation.'),
(5, 4, '15:00:00', '2024-11-05', 'Orthopedic evaluation for knee pain.'),
(6, 4, '10:00:00', '2024-11-06', 'Follow-up for joint recovery.'),
(7, 5, '13:00:00', '2024-11-07', 'Psychiatry session for stress management.'),
(8, 6, '16:00:00', '2024-11-08', 'Neurology check for migraine treatment.'),
(9, 2, '09:00:00', '2024-11-09', 'Skin consultation for allergy review.');