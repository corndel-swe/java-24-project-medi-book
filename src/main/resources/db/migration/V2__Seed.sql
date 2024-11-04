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

-- Clear previous appointments if necessary
DELETE FROM appointments;

-- Insert multiple appointments for doctors over the next 4 days
INSERT INTO appointments (user_id, doctor_id, start_time, date, comment) VALUES
-- Day 1 (November 4, 2024)
(1, 1, '09:00:00', '2024-11-04', 'Routine follow-up check.'),
(1, 1, '10:00:00', '2024-11-04', 'Routine blood pressure check.'),
(1, 1, '11:00:00', '2024-11-04', 'Consultation for diabetes management.'),
(2, 2, '09:00:00', '2024-11-04', 'Skin allergy testing.'),
(2, 2, '10:00:00', '2024-11-04', 'Consultation for acne treatment.'),
(3, 3, '13:00:00', '2024-11-04', 'First wellness visit for child.'),
(4, 4, '14:00:00', '2024-11-04', 'Knee pain evaluation.'),
(5, 5, '15:00:00', '2024-11-04', 'Psychiatry session for stress management.'),
(6, 6, '16:00:00', '2024-11-04', 'Neurology check for migraine treatment.'),

-- Day 2 (November 5, 2024)
(1, 1, '09:00:00', '2024-11-05', 'Annual physical exam.'),
(1, 1, '10:00:00', '2024-11-05', 'Follow-up on blood test results.'),
(1, 1, '11:00:00', '2024-11-05', 'Consultation for weight management.'),
(2, 2, '09:00:00', '2024-11-05', 'Skin consultation for allergy review.'),
(2, 2, '10:00:00', '2024-11-05', 'Follow-up for skin treatment.'),
(3, 3, '13:00:00', '2024-11-05', 'Check-up for chronic illness.'),
(4, 4, '14:00:00', '2024-11-05', 'Joint pain assessment.'),
(5, 5, '15:00:00', '2024-11-05', 'Counseling session for anxiety.'),
(6, 6, '16:00:00', '2024-11-05', 'Migraine treatment review.'),

-- Day 3 (November 6, 2024)
(1, 1, '09:00:00', '2024-11-06', 'Follow-up after surgery.'),
(1, 1, '10:00:00', '2024-11-06', 'Cholesterol check.'),
(1, 1, '11:00:00', '2024-11-06', 'Nutrition consultation.'),
(2, 2, '09:00:00', '2024-11-06', 'Acne treatment follow-up.'),
(2, 2, '10:00:00', '2024-11-06', 'Skin cancer screening.'),
(3, 3, '13:00:00', '2024-11-06', 'Follow-up on child’s health.'),
(4, 4, '14:00:00', '2024-11-06', 'Physical therapy assessment.'),
(5, 5, '15:00:00', '2024-11-06', 'Follow-up for depression management.'),
(6, 6, '16:00:00', '2024-11-06', 'Neurological assessment.'),

-- Day 4 (November 7, 2024)
(1, 1, '09:00:00', '2024-11-07', 'Pre-op consultation.'),
(1, 1, '10:00:00', '2024-11-07', 'Diabetes management follow-up.'),
(1, 1, '11:00:00', '2024-11-07', 'Routine eye examination.'),
(2, 2, '09:00:00', '2024-11-07', 'Follow-up for skin allergy.'),
(2, 2, '10:00:00', '2024-11-07', 'Eczema consultation.'),
(3, 3, '13:00:00', '2024-11-07', 'Wellness check-up.'),
(4, 4, '14:00:00', '2024-11-07', 'Follow-up on knee surgery.'),
(5, 5, '15:00:00', '2024-11-07', 'Group therapy session.'),
(6, 6, '16:00:00', '2024-11-07', 'Follow-up on migraine treatment.');
