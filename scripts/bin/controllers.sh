#!/usr/bin/env bash

# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

bin=`dirname "$0"`
bin=`cd "$bin"; pwd`

. "$bin"/blur-config.sh

export HOSTLIST="${BLUR_HOME_CONF}/controllers"

for controller in `cat "$HOSTLIST"|sed  "s/#.*$//;/^$/d"`; do
 ssh $BLUR_SSH_OPTS $controller $"${@// /\\ }" \
   2>&1 | sed "s/^/$controller: /" &
 if [ "$BLUR_CONTROLLER_SLEEP" != "" ]; then
   sleep $BLUR_CONTROLLER_SLEEP
 fi
done

wait

