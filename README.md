# W16-lab04
Base repository for CS56 W16 lab04 (Open Source)

# Student Instructions

* See https://foo.cs.ucsb.edu/56wiki/index.php/W16:Labs:lab04


# Grader hints

#NOTE FOR GRADERS
Unfortunately I was having some issues pushing my files. I did manage to get them all on here before the due date but they are all under the single commit message "Fixed Snowman"; however, that commit contains all the files of the project. 
Any commits after that will simply be to get the right commit messages for each section of the lab. 

* Use <code>ant -p</code> to see all available tasks
* The grader tasks include these:

<pre>
 gradeMPV1          run MultiPictureViewer for studentName with arg 1
 gradeMPV2          run MultiPictureViewer for studentName with arg 2
 gradeMPV3          run MultiPictureViewer for studentName with arg 3
 gradePV            run simple.PictureViewer for student in studentName property
 gradeSimpleGui1    run simpleGui1 for student in studentName property
</pre>

To run one of those tasks, overriding the student's CSIL id to jgaucho, use, for example:

<code>ant -DstudentName=jgaucho gradePV</code>

You can test this with studentName set to <code>pconrad</code>, <code>andrewberls</code>, or <code>jstaahl</code> as examples.   All of those should work on pconrad, though only the MPV tasks will work for the other two.
