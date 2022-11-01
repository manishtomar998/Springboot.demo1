package com.manish.demo1.services;

import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.manish.demo1.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	public static final String COL_NAME="courses";
	

	@Override
	public List<Course> getCourses() throws InterruptedException, ExecutionException {
		 Firestore dbFirestore = FirestoreClient.getFirestore();
	        CollectionReference documentReference = dbFirestore.collection(COL_NAME);
	        ApiFuture<QuerySnapshot> future = documentReference.get();

	        QuerySnapshot document = future.get();
		
	        List<Course> courses = null;

	        if(!document.isEmpty()) {
	            courses = document.toObjects(Course.class);
	            return courses;
	        }else {
	            return null;
	        }
	}


	@Override
	public String updateCourse(Course course) throws InterruptedException, ExecutionException {
		Firestore dbfirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbfirestore.collection(COL_NAME).document(course.getDocumentId()).set(course);
		return collectionApiFuture.get().getUpdateTime().toString();
	}

	@Override
	public String addCourse(Course course) throws InterruptedException, ExecutionException {
		Firestore dbfirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbfirestore.collection(COL_NAME).document(course.getDocumentId()).set(course);
		return collectionApiFuture.get().getUpdateTime().toString();
	}


	@Override
	public String deleteCourse(String documentId) {
		Firestore dbfirestore = FirestoreClient.getFirestore();
		dbfirestore.collection(COL_NAME).document(documentId).delete();
		return "Deleted " + documentId;
	}


	@Override
	public Course getCourse(String documentId) throws InterruptedException, ExecutionException {
		 Firestore dbFirestore = FirestoreClient.getFirestore();
	        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(documentId);
	        ApiFuture<DocumentSnapshot> future = documentReference.get();

	        DocumentSnapshot document = future.get();
	        Course course = null;

	        if(document.exists()) {
	            course = document.toObject(Course.class);
	            return course;
	        }else {
	            return null;
	        }
	}
	


}
