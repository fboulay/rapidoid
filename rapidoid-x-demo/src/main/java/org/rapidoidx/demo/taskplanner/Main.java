package org.rapidoidx.demo.taskplanner;

/*
 * #%L
 * rapidoid-x-demo
 * %%
 * Copyright (C) 2014 - 2015 Nikolche Mihajlovski
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.app.Apps;
import org.rapidoidx.db.XDB;

@Authors("Nikolche Mihajlovski")
@Since("3.0.0")
public class Main {

	public static void main(String[] args) {
		Apps.run("oauth-no-state");
		XDB.clear();
		for (int i = 0; i < 100; i++) {
			XDB.init("task title=?, description=?, rating=?", "abc" + i, "Some description of the task " + i, i * 10);
		}
	}

}
