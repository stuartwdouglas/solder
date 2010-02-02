/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.weld.test.log;

import org.jboss.testharness.impl.packaging.Artifact;
import org.jboss.testharness.impl.packaging.Classes;
import org.jboss.weld.test.AbstractWeldTest;
import org.slf4j.impl.TestLoggerFactory;
import org.testng.annotations.Test;

/**
 * All the tests related to the @Logger binding type and injection.
 * 
 * @author David Allen
 */
@Artifact
@Classes(packages = { "org.jboss.weld.log" })
public class LoggerInjectionTest extends AbstractWeldTest
{
   @Test
   public void testBasicLogInjection()
   {
      Sparrow bird = getReference(Sparrow.class);
      TestLoggerFactory.INSTANCE.getLogger("").reset();
      bird.generateLogMessage();
      assert TestLoggerFactory.INSTANCE.getLogger("").getLastMessage() != null;
      assert TestLoggerFactory.INSTANCE.getLogger("").getLastMessage().equals("Sparrow");
   }
   
   @Test
   public void testCategorySpecifiedLogger()
   {
      Finch bird = getReference(Finch.class);
      TestLoggerFactory.INSTANCE.getLogger("").reset();
      bird.generateLogMessage();
      assert TestLoggerFactory.INSTANCE.getLogger("").getLastMessage() != null;
      assert TestLoggerFactory.INSTANCE.getLogger("").getLastMessage().equals("Finch");
   }
}
