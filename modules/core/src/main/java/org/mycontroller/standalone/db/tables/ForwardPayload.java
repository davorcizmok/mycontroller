/*
 * Copyright 2015-2018 Jeeva Kandasamy (jkandasa@gmail.com)
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mycontroller.standalone.db.tables;

import org.mycontroller.standalone.db.DB_TABLES;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jeeva Kandasamy (jkandasa)
 * @since 0.0.1
 */
@DatabaseTable(tableName = DB_TABLES.FORWARD_PAYLOAD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
public class ForwardPayload {
    public static final String KEY_ID = "id";
    public static final String KEY_SOURCE_ID = "sourceId";
    public static final String KEY_DESTINATION_ID = "destinationId";
    public static final String KEY_ENABLED = "enabled";

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true, columnName = KEY_ID)
    private Integer id;

    @DatabaseField(canBeNull = false, columnName = KEY_ENABLED)
    private Boolean enabled;

    @DatabaseField(canBeNull = false, foreign = true, uniqueCombo = true, columnName = KEY_SOURCE_ID,
            foreignAutoRefresh = true, foreignAutoCreate = true, maxForeignAutoRefreshLevel = 4)
    private SensorVariable source;

    @DatabaseField(canBeNull = false, foreign = true, uniqueCombo = true, columnName = KEY_DESTINATION_ID,
            foreignAutoRefresh = true, foreignAutoCreate = true, maxForeignAutoRefreshLevel = 4)
    private SensorVariable destination;

}