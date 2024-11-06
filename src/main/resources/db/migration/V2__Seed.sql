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


INSERT INTO doctors (name, speciality, image, biography) VALUES
('Dr. Emily Carter', 'Cardiology', 'emily.jpg',
 'Dr. Emily Carter is a senior consultant cardiologist with nearly two decades of experience in both preventive and interventional cardiology. She commenced her medical training at the University of Oxford, earning top honours, before progressing to a prestigious residency and fellowship in cardiology at St Bartholomew''s Hospital in London. Dr. Carter has a particular interest in preventive cardiology, focusing on lifestyle changes to reduce cardiovascular risk. She is known for her empathetic approach to patient care, balancing technical expertise with a commitment to patient education. Dr. Carter has also conducted pioneering research on the role of diet and exercise in preventing heart disease, which she has published in leading medical journals. Outside her clinical practice, Dr. Carter has collaborated with the British Heart Foundation on community initiatives aimed at reducing heart disease prevalence. In her practice, she advocates for holistic, patient-centred care, striving to empower patients with the knowledge to make informed health choices.'),

('Dr. James Lee', 'Dermatology', 'james.jpg',
 'Dr. James Lee is an award-winning dermatologist with a focus on cosmetic dermatology and dermatologic surgery. Educated at the University of Edinburgh, Dr. Lee completed his training at the renowned King''s College Hospital, specialising in skin cancer treatment and cosmetic procedures. He has since gained over 15 years of experience in both the NHS and private sector, where he provides a full range of dermatological services. Dr. Lee is highly skilled in the latest techniques for skin rejuvenation, including laser therapy, chemical peels, and minimally invasive surgical procedures. He frequently lectures on advanced dermatological care and has authored numerous publications on skin health, particularly focusing on the management of skin cancers and the psychological impacts of chronic skin conditions. Dr. Lee is passionate about patient education, and he believes in a patient-centred approach that includes thorough consultations to tailor treatments to each individual’s needs.'),

('Dr. Sarah Wilson', 'Paediatrics', 'sarah.jpg',
 'Dr. Sarah Wilson is a leading paediatric consultant with a wealth of experience spanning over 15 years, specialising in both general paediatrics and developmental paediatrics. Dr. Wilson graduated with distinction from the University of Cambridge, followed by rigorous residency training at the Royal London Hospital. Throughout her career, she has worked in diverse paediatric settings, including major children''s hospitals across the UK. Dr. Wilson is known for her dedication to understanding the unique needs of each child, especially those with complex developmental disorders. She frequently collaborates with educational psychologists and speech therapists, offering comprehensive care plans. Dr. Wilson has also published extensively on paediatric growth and nutrition, and her research contributions include a landmark study on early childhood developmental milestones. She is dedicated to creating a comfortable and supportive environment for both children and parents, ensuring they feel understood and involved in the care process.'),

('Dr. Michael Tan', 'Orthopaedics', 'michael.jpg',
 'Dr. Michael Tan is a consultant orthopaedic surgeon with a specialisation in sports injuries, trauma surgery, and complex joint reconstruction. He completed his medical degree at Imperial College London, where he developed an interest in orthopaedic surgery. Dr. Tan pursued advanced training through a fellowship at the Royal National Orthopaedic Hospital, focusing on minimally invasive surgical techniques for joint and spinal repair. Over the years, Dr. Tan has worked with elite athletes and NHS patients alike, treating conditions ranging from ligament injuries to severe fractures. Known for his compassionate approach, Dr. Tan combines cutting-edge surgical techniques with rehabilitation to optimise recovery outcomes. He is also an active researcher, regularly presenting findings on osteoarthritis and cartilage regeneration. Dr. Tan strongly believes in a personalised approach to recovery, developing tailored treatment plans to support patients’ individual goals, from returning to sports to achieving everyday mobility.'),

('Dr. Olivia Green', 'Psychiatry', 'olivia.jpg',
 'Dr. Olivia Green is a consultant psychiatrist specialising in adult mental health, including anxiety disorders, depression, and trauma recovery. Dr. Green earned her medical degree from the University of Manchester, followed by a psychiatry residency at King''s College London. With over 12 years of experience, Dr. Green has served in a variety of clinical settings, from community mental health teams to inpatient psychiatric units. Her expertise lies in integrating evidence-based therapies, such as cognitive behavioural therapy and mindfulness, with medication management to create holistic treatment plans. She is actively involved in mental health research, contributing to studies on the impacts of trauma and the effectiveness of non-pharmacological interventions for anxiety. Dr. Green’s practice philosophy emphasises building strong therapeutic relationships, enabling patients to feel safe and supported in exploring difficult emotions and developing coping strategies. Her approachable nature has made her a trusted figure among her patients, many of whom credit her with transforming their mental health journey.'),

('Dr. Noah White', 'Neurology', 'noah.jpg',
 'Dr. Noah White is an experienced consultant neurologist with a subspecialty in epilepsy, neurodegenerative disorders, and migraine management. He began his medical training at the University of Bristol, completing his neurology residency at Queen Square, London, and later specialising in neurophysiology at the Walton Centre. Dr. White has spent over 15 years treating complex neurological cases, both in the NHS and private practice, and is renowned for his diagnostic expertise. His research has significantly contributed to advancements in the treatment of epilepsy and Parkinson''s disease, and he has been instrumental in several clinical trials exploring innovative therapies. Dr. White has a holistic approach to neurology, focusing on understanding each patient’s unique experience of neurological illness. He is deeply committed to patient education, aiming to demystify neurological conditions and empower patients to take an active role in managing their health. Dr. White is also an advocate for mental wellness in neurology, often working in collaboration with psychiatrists to support the emotional well-being of his patients.');

INSERT INTO appointments (user_id, doctor_id, start_time, date, comment) VALUES
-- Day 1 (November 4, 2024)
(1, 1, '09:00', '2024-11-04', 'Routine follow-up check.'),
(1, 1, '10:00', '2024-11-04', 'Routine blood pressure check.'),
(1, 1, '11:00', '2024-11-04', 'Consultation for diabetes management.'),
(2, 2, '09:00', '2024-11-04', 'Skin allergy testing.'),
(2, 2, '10:00', '2024-11-04', 'Consultation for acne treatment.'),
(3, 3, '13:00', '2024-11-04', 'First wellness visit for child.'),
(4, 4, '14:00', '2024-11-04', 'Knee pain evaluation.'),
(5, 5, '15:00', '2024-11-04', 'Psychiatry session for stress management.'),
(6, 6, '16:00', '2024-11-04', 'Neurology check for migraine treatment.'),

-- Day 2 (November 5, 2024)
(1, 1, '09:00', '2024-11-05', 'Annual physical exam.'),
(1, 1, '10:00', '2024-11-05', 'Follow-up on blood test results.'),
(1, 1, '11:00', '2024-11-05', 'Consultation for weight management.'),
(2, 2, '09:00', '2024-11-05', 'Skin consultation for allergy review.'),
(2, 2, '10:00', '2024-11-05', 'Follow-up for skin treatment.'),
(3, 3, '13:00', '2024-11-05', 'Check-up for chronic illness.'),
(4, 4, '14:00', '2024-11-05', 'Joint pain assessment.'),
(5, 5, '15:00', '2024-11-05', 'Counseling session for anxiety.'),
(6, 6, '16:00', '2024-11-05', 'Migraine treatment review.'),

-- Day 3 (November 6, 2024)
(1, 1, '09:00', '2024-11-06', 'Follow-up after surgery.'),
(1, 1, '10:00', '2024-11-06', 'Cholesterol check.'),
(1, 1, '11:00', '2024-11-06', 'Nutrition consultation.'),
(2, 2, '09:00', '2024-11-06', 'Acne treatment follow-up.'),
(2, 2, '10:00', '2024-11-06', 'Skin cancer screening.'),
(3, 3, '13:00', '2024-11-06', 'Follow-up on child’s health.'),
(4, 4, '14:00', '2024-11-06', 'Physical therapy assessment.'),
(5, 5, '15:00', '2024-11-06', 'Follow-up for depression management.'),
(6, 6, '16:00', '2024-11-06', 'Neurological assessment.'),

-- Day 4 (November 7, 2024)
(1, 1, '09:00', '2024-11-07', 'Pre-op consultation.'),
(1, 1, '10:00', '2024-11-07', 'Diabetes management follow-up.'),
(1, 1, '11:00', '2024-11-07', 'Routine eye examination.'),
(2, 2, '09:00', '2024-11-07', 'Follow-up for skin allergy.'),
(2, 2, '10:00', '2024-11-07', 'Eczema consultation.'),
(3, 3, '13:00', '2024-11-07', 'Wellness check-up.'),
(4, 4, '14:00', '2024-11-07', 'Follow-up on knee surgery.'),
(5, 5, '15:00', '2024-11-07', 'Group therapy session.'),
(6, 6, '16:00', '2024-11-07', 'Follow-up on migraine treatment.'),

-- Full day booking for Doctor 1 on November 8, 2024
(1, 1, '09:00', '2024-11-08', 'Morning consultation.'),
(1, 1, '10:00', '2024-11-08', 'Follow-up appointment.'),
(1, 1, '11:00', '2024-11-08', 'Routine check-up.'),
(1, 1, '12:00', '2024-11-08', 'Patient review.'),
(1, 1, '13:00', '2024-11-08', 'Post-surgery follow-up.'),
(1, 1, '14:00', '2024-11-08', 'Follow-up on treatment plan.'),
(1, 1, '15:00', '2024-11-08', 'Medication review.'),
(1, 1, '16:00', '2024-11-08', 'Final consultation of the day.');

