package org.rapidoid.http.handler.lambda;

/*
 * #%L
 * rapidoid-http-server
 * %%
 * Copyright (C) 2014 - 2016 Nikolche Mihajlovski and contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.http.FastHttp;
import org.rapidoid.http.Req;
import org.rapidoid.http.impl.RouteOptions;
import org.rapidoid.lambda.SixParamLambda;
import org.rapidoid.net.abstracts.Channel;
import org.rapidoid.u.U;

@Authors("Nikolche Mihajlovski")
@Since("5.1.0")
public class SixParamLambdaHandler extends NParamLambdaHandler {

	private final SixParamLambda<Object, Object, Object, Object, Object, Object, Object> lambda;

	public SixParamLambdaHandler(FastHttp http, RouteOptions options, SixParamLambda<?, ?, ?, ?, ?, ?, ?> lambda) {
		super(http, options, lambda);
		this.lambda = U.cast(lambda);
	}

	@Override
	protected Object handleReq(Channel channel, boolean isKeepAlive, Req req, Object extra) throws Exception {
		return lambda.execute(arg(req, 0), arg(req, 1), arg(req, 2), arg(req, 3), arg(req, 4), arg(req, 5));
	}

}
